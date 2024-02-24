x <- c(580, 7813, 28266, 59287, 75700,87820, 95314, 126214, 218843, 471497,936851, 1508725, 2072113)
#install the package first from toolbar>packages
library(lubridate)
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\univariate_ts.png')

#frequency values-it is the time interval between two values
#Annual	1
#Quarterly	4
#Monthly	12
#Weekly	52 / 365.25/7=52.18 (use this value)

#CTRL+A to run

mts<-ts(x, start=decimal_date(ymd("2020-01-22")),frequency=365.25/7)
print(decimal_date(ymd("2020-01-22")))
print(decimal_date(ymd("2020-12-31")))
print(mts)
plot(mts)
dev.off()
plot(mts)