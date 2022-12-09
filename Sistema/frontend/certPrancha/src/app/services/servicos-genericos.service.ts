import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicosGenericosService {

  constructor(private http: HttpClient) { }


  public pesquisaCep(corpo:any):Observable<any>{
    return this.http.get<any>(`https://viacep.com.br/ws/${corpo}/json/`);
  }


}
