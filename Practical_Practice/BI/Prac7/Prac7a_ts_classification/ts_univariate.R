#no of cars sold in each month
x<-c(100,215,200,150,80,265,265,245,154,198,187,156)
x.ts= ts(x,start=c(2023,10), end=c(2024,8), frequency=12)
png(file='D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\ts_univariate.png')
print(x.ts)
plot(x.ts, xlab="month",ylab="cars sold",col.main="blue")
dev.off()