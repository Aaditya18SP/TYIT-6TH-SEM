png(file='D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac10\\logistic_regression.png')

#library required=> caTools
install.packages("caTools")
install.packages("ROCR")
library(caTools)
library(ROCR)

#get the dataset
quality_data<- read.csv("D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\BI\\Pracs\\Resources\\quality.csv")
str(quality_data)
table(quality_data$PoorCare)
#generate random data
set.seed(48)

#split the data into training and test data set
split= sample.split(quality_data$PoorCare, SplitRatio=0.75)

training_set<-subset(quality_data,split==TRUE)
test_set<- subset(quality_data,split==FALSE)

#get the model
qualityModel=glm(PoorCare~Narcotics+OfficeVisits,data=training_set,family=binomial)
summary(qualityModel)

#train the model
qualityPredictTrain<- predict(qualityModel, type="response")
summary(qualityPredictTrain)
tapply(qualityPredictTrain,training_set$PoorCare,mean)
table(training_set$PoorCare,qualityPredictTrain>0.5)
table( qualityPredictTrain>0.2,training_set$PoorCare)


#USE THE ROCR PACKAGE
rocrPredict=prediction(qualityPredictTrain,training_set$PoorCare)
rocrPerf=performance(rocrPredict,"tpr","fpr")
plot(rocrPerf,colorize=TRUE,print.cutoffs.at=seq(0,1,by=0.1),text.adj=c(-0.2,1.7))

dev.off()

