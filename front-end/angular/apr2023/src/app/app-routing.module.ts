import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {ContactComponent} from './contact/contact.component';
import { AboutComponent } from './about/about.component';

//to avoid the conflic using alias name
import { HomeComponent as webHomeComponent} from './web/home/home.component';
import {ContactComponent as webContactComponent} from './web/contact/contact.component';
import { AboutComponent as webAboutComponent} from './web/about/about.component';
import { ServiceComponent } from './web/service/service.component';
import { AdminPageComponent } from './web/admin-page/admin-page.component';
/*
home->homeComponent
about->aboutComponent
*/
const routes: Routes = [
  {"path":"home",component:HomeComponent},
  {"path":"contact",component:ContactComponent},
  {"path":"about",component:AboutComponent},
  {"path":"web/home",component:webHomeComponent},
  {"path":"web/contact",component:webContactComponent},
  {"path":"web/about",component:webAboutComponent},
  {"path":"web/service",component:ServiceComponent},
  {"path":"web/admin",component:AdminPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
