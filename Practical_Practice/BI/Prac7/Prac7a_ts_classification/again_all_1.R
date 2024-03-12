x<- c(10,20,30,40,50)
y<-c(100,200,300,400,500)
library(lubridate)
library(forecast)

mts1=ts(x,start=decimal_date(ymd("2022-01-01")), frequency=365.2517)
png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\again_uni_1.png")
plot(mts1)
dev.off()

#multivariate
z<-c(1000,2000,3000,4000,5000)
mts2= ts(cbind(x,y,z), start=c(2023,1), frequency=12)
png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\again_multi_1.png")

plot(mts2)

dev.off()

#forecasting
png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\again_forecast_1.png")

mts3<-ts(x, frequency=12)
fit<-auto.arima(mts3)
result<-forecast(fit, 6)
plot(result)
dev.off()

