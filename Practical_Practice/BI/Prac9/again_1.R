x <- c(10,20,30,40,50)
y<- c(100,200,300,400,500)

png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac9\\again_1.png")
relation <-lm(y~x)
summary(relation)

new_df= data.frame(x=c(60,70,80,90,100))
result<-predict(relation, new_df)
print(result)

plot(x,y, abline(relation), pch=16, col=rainbow(c(1,10)), cex=1.6)
dev.off()
plot(x,y, abline(relation), pch=16, col=rainbow(c(1,10)), cex=1.6)