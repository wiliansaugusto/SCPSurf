import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarHorizontalPosition, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class SnackBarServiceService {

  private defaultDuration: number = 5;
  horizontalPosition: MatSnackBarHorizontalPosition = 'right';
   verticalPosition: MatSnackBarVerticalPosition = 'top';

   constructor(private snackBar : MatSnackBar) { }

   public  showSnackBar(message : string, action : string, durationParam?: number){
     this.snackBar.open(message, action,
        {duration :durationParam!= null? durationParam *1000: this.defaultDuration*1000}
         );
   }
   public  showSnack(message : string, action : string, durationParam?: number){
     this.snackBar.open(message, action,
        {duration :durationParam!= null? durationParam *1000: this.defaultDuration*1000,
         verticalPosition:this.verticalPosition,
         horizontalPosition:this.horizontalPosition}
         );
   }
 }
