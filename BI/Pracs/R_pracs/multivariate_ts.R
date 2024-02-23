# Weekly data of COVID-19 positive cases and
# weekly deaths from 22 January, 2020 to
# 15 April, 2020
#MULTIVARIATE MEANS MULTIPLE CHARTS INTO ONE SCREEN/IMAGE
#avoid empty lines
positiveCases<-c(580, 7813, 28266, 59287,75700, 87820, 95314, 126214,218843, 471497, 936851,1508725, 2072113)
deaths <- c(17, 270, 565, 1261, 2126, 2800,3285, 4628, 8951, 21283, 47210,88480, 138475)
# library required for decimal_date() function
library(lubridate)
print(cbind(positiveCases ,deaths ))
#cbind combines the two vectors as columns
#positiveCases deaths
#580            17
#7813           270 
#create a ts object
mts<-ts(cbind(positiveCases,deaths),start=decimal_date(ymd("2020-01-22")),frequency=52.18)
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\multivariate_ts.png')
print(mts)
plot(mts)
dev.off()

 