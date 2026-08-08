import { NgModule } from '@angular/core';
import { MaskAccountPipe } from './mask.account-pipe';

@NgModule({
  declarations: [MaskAccountPipe],
  exports: [MaskAccountPipe]
})
export class PipesModule {}
