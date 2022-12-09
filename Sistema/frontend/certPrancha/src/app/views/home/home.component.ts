import { SnackBarServiceService } from './../../services/snack-bar-service.service';
import { Component, OnInit, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  propiedadeMock={
    id:'78541200'
  }
  mensagemPropiedade={
    id:'',
    mensagem:''
  };

  public propiedadeForm!:FormGroup;
  @ViewChild("propiedadeFormDirective") loginFormGroupDirective !: FormGroupDirective;
  
  constructor(private form: FormBuilder, private snack: SnackBarServiceService) { }

  ngOnInit(): void {
    this.propiedadeForm = this.form.group({
      idPropiedade:['']
    })
  }
  verificarPropiedade(){
    if(this.propiedadeForm.value['idPropiedade'] == this.propiedadeMock.id){
      this.mensagemPropiedade.mensagem = "Encontrado(a) o propietário da prancha"
      this.mensagemPropiedade.id='1';
    }else{
        this.snack.showSnackBar("Não encontrada a propiedade", "OK")
        this.propiedadeForm.reset();
        this.mensagemPropiedade.mensagem = "Não encontrada a propiedade da prancha"
        this.mensagemPropiedade.id='0';

    }

  }
}
