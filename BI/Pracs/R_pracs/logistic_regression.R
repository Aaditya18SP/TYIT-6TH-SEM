quality<- read.csv("D:\\TYIT_AADITYA_A029\\TYIT-6TH-SEM\\BI\\Pracs\\Resources\\quality.csv")
str(quality)
library(caTools)

# to randomly generate a list to true false values
#the seed can be any random number.
#it is used to generate the same random sequence everytime
set.seed(88)
print(val)
#132 total rows in csv
#split is a random vector which is generated based on values from the poorcare variable where 75% is true and 25% is false
split= sample.split(quality$PoorCare,SplitRatio=0.75)
#print(split)
#print(typeof(split)) #logical is the dataype
qualityTrain=subset(quality,split==TRUE)
qualityTest=subset(quality,split==FALSE)
#numrows
nrow(qualityTrain)
nrow(qualityTest)
#print(qualityTest)

QualityLog=glm(PoorCare~OfficeVisits+Narcotics,data=qualityTrain,family=binomial)
summary(QualityLog)
predictTrain= predict(QualityLog,type="response")
summary(predictTrain)
#apply the mean function to the predictTrain grouped by the PoorCare variable 
#basically we find the mean of TRUE and FALSE values in the predicted model
tapply(predictTrain,qualityTrain$PoorCare,mean)
table(qualityTrain$PoorCare,predictTrain>0.5)
table(qualityTrain$PoorCare,predictTrain>0.2)
png(file='D:\\TYIT_AADITYA_A029\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\logistic_regression.png')
library(ROCR)


ROCRpred=prediction(predictTrain,qualityTrain$PoorCare)
ROCRperf=performance(ROCRpred,"tpr","fpr")
print(ROCRpred)
print(ROCRperf)
summary(ROCRperf)
plot(ROCRperf)
plot(ROCRperf,colorize=TRUE)
plot(ROCRperf,colorize=TRUE,print.cutoffs.at=seq(0,1,by=0.1),text.adj=c(-0.2,1.7))

dev.off()