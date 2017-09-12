import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<a routerLink="/produto" routerLinkActive="active">Produto</a>
<br/>
<a routerLink="/empresa" routerLinkActive="active">Empresa</a>
<br/>
<a routerLink="/local" routerLinkActive="active">Local</a>
<br/>
<a routerLink="/usuario" routerLinkActive="active">Usuario</a>
<router-outlet></router-outlet>`
})
export class AppComponent {
}
