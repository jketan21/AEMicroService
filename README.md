# AEMicroService

Added Simple Microservice developed using Spring boot with producer & consumer patter (GET & POST) which uses Queue to have the data in FIFO pattern. The POST API will create the user info with username & city information and GET API will retrieve the same in the FIFO order since its a Aueue implimentation. Also added Junit test cases to test the same.
We could use this microservices as a base to add more customer information like first/last name, address, phone, email etc and can be user as a USERINFO microservice which will have all the user related information. Having microservices would help in pi pointing the issues and are easily maintainable.
