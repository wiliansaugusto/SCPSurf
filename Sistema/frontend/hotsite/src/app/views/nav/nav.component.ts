import { Component, OnInit, ViewChild } from '@angular/core';
import { MatAccordion } from '@angular/material/expansion';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  id = sessionStorage.getItem('id');
  @ViewChild(MatAccordion) accordion!: MatAccordion;
  constructor(private router: Router) { }
  ngOnInit(): void {
  }
  sair(){
    alert('test');
    sessionStorage.clear();
    this.router.navigate(['/'])

  }



}
