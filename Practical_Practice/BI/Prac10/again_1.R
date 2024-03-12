png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac10\\again_3.png")
qualityOgData=read.csv("D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\BI\\Pracs\\Resources\\quality.csv")
str(qualityOgData)
table(qualityOgData$PoorCare)

library(caTools)
library(ROCR)

set.seed(48)
split=sample.split(qualityOgData,SplitRatio=0.75)
trainData=subset(qualityOgData,split==TRUE)
testData=subset(qualityOgData,split==FALSE)
#row(trainData)

#get/create the model
model= glm(PoorCare~Narcotics+OfficeVisits, trainData$PoorCare, family=binomial)

#predict the values using the model
pred= predict(model,type="response")

#group the predicted values acc to the PoorCare values and find their mean
tapply(pred, trainData$PoorCare,mean)

#see a table with which we can calculate the tpr(true positive rate) and fpr(false positive rate)
table(pred >0.5,trainData$PoorCare)


#use ROCR package to give the tpr and fpr

#label the predictions made earlier
#pred is a vector that contains the vectors and label it with PoorCare values
rocrPred=prediction(pred,trainData$PoorCare)

#we are taking tpr and fpr as performance measures
perf=performance(rocrPred, "tpr","fpr")

#plot it
plot(perf, colorize=TRUE, print.cutoffs.at=seq(0,1,by=0.1),text.adj=c(-0.2,1.7))
dev.off()