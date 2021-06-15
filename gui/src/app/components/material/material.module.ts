import {
  NgModule
} from "@angular/core";

import {MatButtonToggleModule} from "@angular/material/button-toggle";
  import {MatAutocompleteModule} from "@angular/material/autocomplete";
  import {MatSlideToggleModule} from "@angular/material/slide-toggle";
  import {MatBottomSheetModule} from "@angular/material/bottom-sheet";
  import {MatGridListModule} from "@angular/material/grid-list";
  import {MatToolbarModule} from "@angular/material/toolbar";
  import {MatSidenavModule} from "@angular/material/sidenav";
  import {MatButtonModule} from "@angular/material/button";
  import {MatBadgeModule} from "@angular/material/badge";
  import {MatChipsModule} from "@angular/material/chips";
  import {MatTableModule} from "@angular/material/table";
  import {MatIconModule} from "@angular/material/icon";
  import {MatListModule} from "@angular/material/list";
  import {MatMenuModule} from "@angular/material/menu";
  import {MatTabsModule} from "@angular/material/tabs";
  import {MatCardModule} from "@angular/material/card";
  import { MatCheckboxModule} from "@angular/material/checkbox";
  import {MatFormFieldModule} from "@angular/material/form-field";
  import { MatInputModule } from '@angular/material/input';
  import { MatDialogModule } from '@angular/material/dialog';
import {
  ScrollingModule
} from "@angular/cdk/scrolling";

const MaterialComponents = [
  MatButtonToggleModule,
  MatAutocompleteModule,
  MatButtonToggleModule,
  MatBottomSheetModule,
  MatSlideToggleModule,
  MatCheckboxModule,
  MatFormFieldModule,
  MatGridListModule,
  MatSidenavModule,
  MatToolbarModule,
  MatButtonModule,
  ScrollingModule,
  MatBadgeModule,
  MatTableModule,
  MatChipsModule,
  MatIconModule,
  MatMenuModule,
  MatListModule,
  MatCardModule,
  MatTabsModule,
  MatInputModule,
  MatDialogModule 
];

@NgModule({
  imports: [MaterialComponents],
  exports: [MaterialComponents],
})
export class MaterialModule {}
