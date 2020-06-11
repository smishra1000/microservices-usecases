import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { StudentComponent } from './student/student.component';
import { NotificationComponent } from './notification/notification.component';

import {StudentService} from './student.service';
import { NotificationService} from './notification.service';
import { CourseComponent } from './course/course.component';
import { PaymentComponent } from './payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    StudentComponent,
    NotificationComponent,
    CourseComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [StudentService,NotificationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
