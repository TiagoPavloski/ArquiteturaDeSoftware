import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<a routerLink="/produto" routerLinkActive="active">Produto</a>
<a routerLink="/empresa" routerLinkActive="active">Empresa</a>
<router-outlet></router-outlet>`
})
export class AppComponent {
}
