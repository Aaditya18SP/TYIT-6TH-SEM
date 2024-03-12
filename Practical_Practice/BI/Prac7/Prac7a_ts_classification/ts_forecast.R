#Forecasting using arima model
#library required=> forecast
#install.packages('forecast')

x=c(100.23, 1356,232.3843,3473.78,38439.89,38492,832.893.38,23.98,261.29)
mts=ts(x, start=decimal_date(ymd("2023-01-30")),frequency=52.18)

#predict for next four weeks
library(forecast)
fit=auto.arima(mts)
print(fit)
predicted_values=forecast(fit,12)
png(file='D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\ts_forecast.png')
print(predicted_values)
plot(predicted_values)
dev.off()
plot(predicted_values)

