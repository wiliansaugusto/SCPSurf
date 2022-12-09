import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormGroupDirective } from '@angular/forms';

@Component({
  selector: 'app-dashboard-shapper',
  templateUrl: './dashboard-shapper.component.html',
  styleUrls: ['./dashboard-shapper.component.css']
})
export class DashboardShapperComponent implements OnInit {

//tras o valor para o TS
public searchClient!:FormGroup;
@ViewChild("searchClientFormDirective") loginFormGroupDirective !: FormGroupDirective;



  shapper: any = {
    name:"Willians Augusto"
  }

  clientesOrcamento:any=[
   { id:'1',
    nome:"Pedro Scoob",
    idade:"45",
    orcamento:{tpPrancha:"Long", tamanho:"8pes", valor:"R$ 3300,00"},
    contato:{whats:"13988012490", email:"izaizinha@yahoo.com.br"}
   },
   { id:'2',
    nome:"Pedro Jorge",
    idade:"47",
    orcamento:{tpPrancha:"Pranchinha", tamanho:"4pes", valor:"R$ 2500,00"},
    contato:{whats:"13981976700", email:"wiliansaugusto@gmail.com"}
  },
   { id:'3',
nome:"Raul Seixas",
idade:"22",
orcamento:{tpPrancha:"Middle", tamanho:"6pes", valor:"R$ 1500,00"},
contato:{whats:"13974217260", email:"master@master.com"}
}

  ]
  constructor(private form: FormBuilder) { }

  ngOnInit(): void {
    this.searchClient = this.form.group({
      clienteSearch:['']
    })
  }
searchCliente(){
  /*
    Precisa criar um serviço para buscar os clientes
  
  */
    alert(this.searchClient.value['clienteSearch']);
    
    
}
}
