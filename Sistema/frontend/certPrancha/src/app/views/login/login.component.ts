import { SnackBarServiceService } from './../../services/snack-bar-service.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormGroupDirective } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login=[{
    nome:"willians",
    pswd:'2124',
    id:'1'
  },{
    nome:"willians augusto",
    pswd:'785412',
    id:'2'
  }]

  public loginForm!:FormGroup;
  @ViewChild("loginFormDirective") loginFormGroupDirective !: FormGroupDirective;
  public sessionId!:any;

  constructor(private form: FormBuilder, private snack:SnackBarServiceService,
    private router:Router) { }

  ngOnInit(): void {
    console.log(sessionStorage.getItem('sessionId'));
    this.loginForm = this.form.group({
      nome:[''],
      pswd:[''],
    })
  }

  onSubmit(){

    var loginTeste  = {
      nome: this.loginForm.value['nome'],
      pswd: this.loginForm.value['pswd']
    }

    if((this.login[0].nome == loginTeste.nome && this.login[0].pswd == loginTeste.pswd)){
      console.log("Logado")
      this.snack.showSnack("Seja bem vindo: "+loginTeste.nome, "Ok");
      this.router.navigate(['/dashboardgerenciamento']);


    }else if (this.login[1].nome == loginTeste.nome && this.login[1].pswd == loginTeste.pswd){
      console.log("Logado")
      this.snack.showSnack("Seja bem vindo: "+loginTeste.nome, "Ok");
      this.router.navigate(['/dashboardshapper']);

    }else{
      this.loginForm.reset()
      this.snack.showSnack("Usuário ou senha não encontrados", "Ok");

    }
    }

}
