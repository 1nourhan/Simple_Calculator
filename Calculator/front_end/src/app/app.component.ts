import { Component } from '@angular/core';
import{HttpClient}from'@angular/common/http';
// import { HttpClientModule, HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'homework';
  x:string=""
  display(y:string){
    this.x = this.x + y
  }
  delete(){
    this.x = this.x.substring(0,this.x.length-1)
  }
  CE(){
      this.x = ""
  }

  b:any
  constructor(private http:HttpClient){}
  send(y:string){
    this.http.get('http://localhost:8080/print/result',
    {
      responseType:'text',
      params:{
        exp:y
      },
      observe:'response'
    }).subscribe(response=>{
        this.b = response.body
        console.log(this.b)
    })
    
  }
  sending(){
    // this.x = this.x + y
    this.send(this.x)
  }     

}

