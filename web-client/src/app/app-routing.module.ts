import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { NotificationComponent } from './notification/notification.component';
import { CourseComponent } from './course/course.component';
import { PaymentComponent } from './payment/payment.component';


const routes: Routes = [
  { path: 'student', component: StudentComponent },
  { path: 'notification', component: NotificationComponent },
  { path: 'course', component: CourseComponent },
  { path: 'payment', component: PaymentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
