#clustering
png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac8\\again_1.png")
newiris<-iris
newiris$Species<-NULL
kc<-kmeans(newiris,3)
table(iris$Species, kc$cluster)
plot(newiris[,c("Petal.Width","Petal.Length")],col=kc$cluster)
points(kc$centers[,c("Petal.Width", "Petal.Length")],col=1:3, pch=10,cex=4)
dev.off()
