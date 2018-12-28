import { NgMaterialWrapperModule } from './ng-material-wrapper.module';

describe('NgMaterialWrapperModule', () => {
  let ngMaterialWrapperModule: NgMaterialWrapperModule;

  beforeEach(() => {
    ngMaterialWrapperModule = new NgMaterialWrapperModule();
  });

  it('should create an instance', () => {
    expect(ngMaterialWrapperModule).toBeTruthy();
  });
});
