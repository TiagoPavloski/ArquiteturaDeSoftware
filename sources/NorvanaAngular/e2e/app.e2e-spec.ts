import { NorvanaAngularPage } from './app.po';

describe('norvana-angular App', () => {
  let page: NorvanaAngularPage;

  beforeEach(() => {
    page = new NorvanaAngularPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
