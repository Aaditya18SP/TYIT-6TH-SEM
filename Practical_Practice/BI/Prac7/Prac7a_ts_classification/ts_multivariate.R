#multivariate timeseries
x=c(10,20,30,40,50,60)
y=c(100,200,300,400,500,600)
library(lubridate)
sample.ts=ts(cbind(x,y), start=decimal_date(ymd("2022-01-22")), frequency=365.2517)
print(sample.ts)
png(file='D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\ts_multivariate.png')
plot(sample.ts)
dev.off()

