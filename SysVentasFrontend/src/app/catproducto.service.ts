import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'; 
@Injectable({
  providedIn: 'root'
})
export class CatproductoService {

  constructor(private http: HttpClient) { }

  firstClick() {
    return console.log('clicked Rest Cat Product');
  }  


}
