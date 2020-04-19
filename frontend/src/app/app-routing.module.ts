import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ErrorComponent } from './pages/error/error.component';
import { MerchComponent } from './pages/merch/merch.component';
import { MerchTemplateComponent } from './pages/merch/merch-template/merch-template.component';
import { MerchFormComponent } from './pages/merch/merch-form/merch-form.component';
import { EventsComponent } from './pages/events/events.component';
import { EventTemplateComponent } from './pages/events/event-template/event-template.component';
import { EventsFormComponent } from './pages/events/events-form/events-form.component';
import { AboutUsComponent } from './pages/about-us/about-us.component';
import { ContactComponent } from './pages/contact/contact.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'error',
    component: ErrorComponent
  },
  {
    path: 'merchs',
    component: MerchComponent
  },
  {
    path: 'merch-template',
    component: MerchTemplateComponent
  },
  {
    path: 'merch-form',
    component: MerchFormComponent
  },
  {
    path: 'events',
    component: EventsComponent
  },
  {
    path: 'event-template',
    component: EventTemplateComponent
  },
  {
    path: 'event-form',
    component: EventsFormComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },


  //Error page
  /*
  {
    path: '**',
    component: HomeComponent
  }
  {
    path: '**',
    redirectTo: 'tool/login'
  }
  */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
