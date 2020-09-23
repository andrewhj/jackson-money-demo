# jackson-money-demo
Demo application for serializing and deserializing jsr354 using Jackson

currently has 2 endpoints:
http://localhost:8080 will respond with a MonetaryAmount (triggering Serialization)

http://localhost:8080/client will make use RestTemplate to call the above service and respond with the given MonetaryAmount, (Serialization -> Deserialization -> Serialization)
