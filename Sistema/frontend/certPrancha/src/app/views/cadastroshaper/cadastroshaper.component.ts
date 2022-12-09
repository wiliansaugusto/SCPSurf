import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormGroupDirective, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ServicosGenericosService } from 'src/app/services/servicos-genericos.service';
import { SnackBarServiceService } from 'src/app/services/snack-bar-service.service';

@Component({
  selector: 'app-cadastroshaper',
  templateUrl: './cadastroshaper.component.html',
  styleUrls: ['./cadastroshaper.component.css']
})
export class CadastroshaperComponent implements OnInit {


  @ViewChild("shapperFormDirective") shapperFormDirective !: FormGroupDirective;
  shapperForm!:FormGroup;


  imagem!: File;
  localURl:any;
  imgResult:any;

  constructor(private form: FormBuilder,
    private service: ServicosGenericosService,
     private snack:SnackBarServiceService, private rota:Router) { }

  ngOnInit(): void {

    this.shapperForm = this.form.group({
      nomeShapper:['', Validators.required],
      nomeUsuario:['', Validators.required],
      shapperPswd:['', Validators.required],
      telefone:['', Validators.required],
      dataNascimento:['', Validators.required],
      img_thumb:[''],
      CPF:['', Validators.required]


    });
  }

  onSubmit(){
    if(!this.shapperForm.invalid){
      this.snack.showSnackBar("Cadastro efetuado com sucesso","OK");
      this.rota.navigate(['/login'])
    }else{
      this.snack.showSnackBar('Confirme por favor os seus dados', "OK")
    }


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

validarCPF(event:any){
  let testing = this.isValidCPF(this.shapperForm.value['CPF']);
  console.log("CPF", testing, "\n", this.shapperForm.value['CPF']);

  if(!testing){
    this.snack.showSnackBar('CPF não é valido', "OK");
    this.shapperForm.patchValue({"CPF": ""})
  }

}
}
