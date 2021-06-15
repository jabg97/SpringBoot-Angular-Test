import {
  Routes,
  RouterModule
} from "@angular/router";
import {
  NgModule
} from "@angular/core";


import {
  SideNavComponent
} from "./pages/home/layout/side-nav/side-nav.component";
import {
  AppBarComponent
} from "./pages/home/layout/app-bar/app-bar.component";

import {
  MainComponent
} from "./pages/home/main/main.component";
import {
  HomeComponent
} from "./pages/home/home.component";

import {
  AuthComponent
} from "./pages/auth/auth.component";

import {
  EstudiantesDialogComponent
} from "./pages/home/main/estudiantes-dialog/estudiantes-dialog.component";

const routes: Routes = [{
    path: "",
    component: HomeComponent,
    children: [{
        path: "",
        component: MainComponent,
      }
    ],
  },{
    path: "",
    component: HomeComponent,
    children: [{
        path: "",
        component: MainComponent,
      }
    ],
  },
  {
    path: "auth",
    component: AuthComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
export const RoutingComponents = [
  SideNavComponent,
  AppBarComponent,
  HomeComponent,
  MainComponent,
  AuthComponent,
  EstudiantesDialogComponent
];
