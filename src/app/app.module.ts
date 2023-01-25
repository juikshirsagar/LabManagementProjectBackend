import {  HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignupPageComponent } from './signup-page/signup-page.component';

import { LabTestComponent } from './lab-test/lab-test.component';
import { AddLabTestComponent } from './add-lab-test/add-lab-test.component';
import { UpdateTestComponent } from './update-test/update-test.component';
import { PatientComponent } from './patient/patient.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { ReportComponent } from './report/report.component';
import { HomeComponent } from './home/home.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { Router, RouterModule } from '@angular/router';




@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    SignupPageComponent,
   
        LabTestComponent,
        AddLabTestComponent,
        UpdateTestComponent,
        PatientComponent,
        AddPatientComponent,
        UpdatePatientComponent,
        ReportComponent,
        HomeComponent,
       DashboardComponent
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
   RouterModule,
  
    
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
