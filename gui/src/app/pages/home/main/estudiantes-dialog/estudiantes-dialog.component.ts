import { Component, Inject, ViewEncapsulation } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
    selector: 'estudiantes-dialog',
    templateUrl: './estudiantes-dialog.component.html',
    styleUrls: ['./estudiantes-dialog.component.css'],
    encapsulation: ViewEncapsulation.None
})
export class EstudiantesDialogComponent {

  estudiantes: any[] = [];
  constructor(
    public dialogRef: MatDialogRef<EstudiantesDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) 
  { }
  
  close() {
    this.dialogRef.close();
}

}