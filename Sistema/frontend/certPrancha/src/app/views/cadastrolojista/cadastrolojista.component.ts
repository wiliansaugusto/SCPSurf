import { SnackBarServiceService } from './../../services/snack-bar-service.service';
import { ServicosGenericosService } from './../../services/servicos-genericos.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormGroupDirective, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastrolojista',
  templateUrl: './cadastrolojista.component.html',
  styleUrls: ['./cadastrolojista.component.css']
})
export class CadastrolojistaComponent implements OnInit {

  tabs:any = ['CadastroLoja', 'Shapper','Resumo'];
  selected = new FormControl(0);
  shapper:any =[]

  imagem!: File;
  localURl:any;
  imgResult:any;

  public lojaForm!:FormGroup;
  @ViewChild("lojaFormDirective") loginFormGroupDirective !: FormGroupDirective;
  shaperForm!:FormGroup;
  @ViewChild("shaperFormDirective") shapperFormGroupDirective !: FormGroupDirective;


  constructor(private form: FormBuilder,
    private service: ServicosGenericosService,
     private snack:SnackBarServiceService ) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('sessionId'));
    this.lojaForm = this.form.group({
      nomePropietario:['', Validators.required],
      pswd:['', Validators.required],
      nmUsuario:['', Validators.required],
      nomefantasia:['', Validators.required],
      nomeComercial:['', Validators.required],
      emailProrietario:['', Validators.required, Validators.email],
      emailComercial:['', Validators.required, Validators.email],
      CPF:['', Validators.required],
      CNPJ:[''],
      CEP:['', Validators.required],
      logradouro:['', Validators.required],
      numeroResidencia:['', Validators.required],
      complementoResidencia:[''],
      bairro:['', Validators.required],
      cidade:['', Validators.required],
      estado:['', Validators.required],
      img_thumb:[''],
      telefone:['', Validators.required],
      dataNascimento:['', Validators.required]

    })

    this.shaperForm =  this.form.group({
      shaperSim:[''],
      nomeShapper:[''],
      emailShapper:[''],
      dataNascimento:[''],
      telefoneShaper:['']
    })

  }



  onSubmitLoja(){

let cpf = this.isValidCPF(this.lojaForm.value["CPF"])


let cnpj = this.validarCNPJ(this.lojaForm.value['CNPJ'])

   if(!cpf){
      this.snack.showSnackBar("CPF Invalido", "OK")
      this.lojaForm.patchValue({"CPF" : ""});
   }
   if(!cnpj && this.lojaForm.value['CNPJ'] != ""){
    this.snack.showSnackBar("CNPJ Invalido", "OK")
    this.lojaForm.patchValue({"CNPJ" : ""});
 }
    if(!this.lojaForm.invalid){
      this.selected.setValue(1)

    }



 }
 onSubmitShaper(){
  const objShaper={
    shaperSim : this.shaperForm.value['shaperSim'],
    nomeShapper : this.shaperForm.value['nomeShapper'],
    emailShapper : this.shaperForm.value['emailShapper'],
    dataNascimento : this.shaperForm.value['dataNascimento'],
    telefoneShaper : this.shaperForm.value['telefoneShaper']
  }


  this.shapper.push(objShaper);

  this.shaperForm.patchValue({'nomeShapper':''});
  this.shaperForm.patchValue({'emailShapper':''});
  this.shaperForm.patchValue({'dataNascimento':''});
  this.shaperForm.patchValue({'telefoneShaper':''});

 }

 goToResume(){
  this.selected.setValue(2)

  if(this.shaperForm.value['shaperSim'] <= 2){
    let flag = true;

    this.shapper.forEach((element:any) => {
        if(element.nomeShapper == this.lojaForm.value['nomePropietario'])
        flag=false;
    });


    if(flag){
      const objShaper={
        nomeShapper : this.lojaForm.value['nomePropietario'],
        emailShapper : this.lojaForm.value['emailProrietario'],
        dataNascimento : this.lojaForm.value['dataNascimento'],
        telefoneShaper : this.lojaForm.value['telefone']
      }
      this.shapper.push(objShaper)
    }

  }
 }
   buscaCEP(event:any){
    let corpo = this.lojaForm.value['CEP'];
    this.service.pesquisaCep(corpo).subscribe(
      (resp:any)=>{

        this.lojaForm.patchValue({
          'complementoResidencia':resp.complemento,
          'logradouro':resp.logradouro,
          'bairro':resp.bairro,
          'cidade':resp.localidade,
          'estado':resp.uf + " - BR"
        }) ;
      },(err:any)=>{
        this.snack.showSnack("Endereço não encontrado", "OK")
      }
    )
  }

  selectedFiles(event: any){
    this.imagem = <File>event.target.files[0]
      if(event.target.files && event.target.files[0]){
        var reader = new FileReader();
        reader.onload = (event:any)=>{
        this.localURl = event.target.result;
        this.imgResult = reader.result;

    }
    reader.readAsDataURL(event.target.files[0]);


  }

}
delShapper(i:any){

  this.shapper.splice(i)

}

 isValidCPF(cpf: string) {
  if (typeof cpf !== "string") return false
  cpf = cpf.replace(/[\s.-]*/igm, '')
  if (
      !cpf ||
      cpf.length != 11 ||
      cpf == "00000000000" ||
      cpf == "11111111111" ||
      cpf == "22222222222" ||
      cpf == "33333333333" ||
      cpf == "44444444444" ||
      cpf == "55555555555" ||
      cpf == "66666666666" ||
      cpf == "77777777777" ||
      cpf == "88888888888" ||
      cpf == "99999999999"
  ) {
      return false
  }
  var soma = 0
  var resto
  for (var i = 1; i <= 9; i++)
      soma = soma + parseInt(cpf.substring(i-1, i)) * (11 - i)
  resto = (soma * 10) % 11
  if ((resto == 10) || (resto == 11))  resto = 0
  if (resto != parseInt(cpf.substring(9, 10)) ) return false
  soma = 0
  for (var i = 1; i <= 10; i++)
      soma = soma + parseInt(cpf.substring(i-1, i)) * (12 - i)
  resto = (soma * 10) % 11
  if ((resto == 10) || (resto == 11))  resto = 0
  if (resto != parseInt(cpf.substring(10, 11) ) ) return false
  return true
}

 validarCNPJ(cnpj: any) {


  if (cnpj == '') return false;

  if (cnpj.length != 14)
      return false;


  if (cnpj == "00000000000000" ||
      cnpj == "11111111111111" ||
      cnpj == "22222222222222" ||
      cnpj == "33333333333333" ||
      cnpj == "44444444444444" ||
      cnpj == "55555555555555" ||
      cnpj == "66666666666666" ||
      cnpj == "77777777777777" ||
      cnpj == "88888888888888" ||
      cnpj == "99999999999999")
      return false;


  let tamanho = cnpj.length - 2
  let numeros = cnpj.substring(0, tamanho);
  let digitos = cnpj.substring(tamanho);
  let soma = 0;
  let pos = tamanho - 7;

  for (let i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
          pos = 9;
  }
  let resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
  if (resultado != digitos.charAt(0)) return false;
  tamanho = tamanho + 1;
  numeros = cnpj.substring(0, tamanho);
  soma = 0;
  pos = tamanho - 7;
  for (let i = tamanho; i >= 1; i--) {
      soma += numeros.charAt(tamanho - i) * pos--;
      if (pos < 2)
          pos = 9;
  }
  resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
  if (resultado != digitos.charAt(1))
      return false;

  return true;

}
}
