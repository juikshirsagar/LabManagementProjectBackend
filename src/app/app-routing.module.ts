import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddLabTestComponent } from './add-lab-test/add-lab-test.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { LabTestComponent } from './lab-test/lab-test.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { PatientComponent } from './patient/patient.component';
import { ReportComponent } from './report/report.component';
import { SignupPageComponent } from './signup-page/signup-page.component';
import { UpdatePatientComponent } from './update-patient/update-patient.component';
import { UpdateTestComponent } from './update-test/update-test.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'login',component:LoginPageComponent},
  {path:'signup',component:SignupPageComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'labtest',component:LabTestComponent},
  {path:'addlab',component:AddLabTestComponent},
  {path:'update/:id',component:UpdateTestComponent},
  {path:'patients',component:PatientComponent},
  {path:'addpatient',component:AddPatientComponent},
  {path:'patientupdate',component:UpdatePatientComponent},
  {path:'report',component:ReportComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
