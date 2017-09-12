import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpCliente } from './http_cliente.component';



@NgModule({
  declarations: [
    AppComponent,
    HttpCliente
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
  {
    path: 'cliente',
    component: HttpCliente
  }
])
  ],
  providers: [HttpCliente],
  bootstrap: [AppComponent]
})
export class AppModule { }
