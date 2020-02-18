# easywebmockdemo

`easywebmockdemo` is a demo project for [easywebmock](https://github.com/Wuvist/easywebmock/)

It's built with kotlin & Spring Boot, showing a simple web service that consume a backend service and render json result to html page.

* [MockitoControllerTest](src/test/kotlin/com/blogwind/easywebmockdemo/MockitoControllerTest.kt) show controller test case written with [mockito](https://site.mockito.org/)
* [WebMockControllerTest](src/test/kotlin/com/blogwind/easywebmockdemo/WebMockControllerTest.kt) show same test case written with [easywebmock](https://github.com/Wuvist/easywebmock/) 

## Run

Simple "backend service" with python 3:

```bash
cd src/main/resources
python -m http.server
```