newiris <- iris
#print(newiris)
newiris$Species <- NULL
kc <-kmeans(newiris,3)
print(kc)
table(iris$Species,kc$cluster)
plot(newiris[c("Sepal.Length","Sepal.Width")],col=kc$cluster)
points(kc$centers[,c("Sepal.Length","Sepal.Width")],col=1:3,pch=8,cex=2)
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\clutering.png')
dev.off()
plot(newiris[c("Sepal.Length","Sepal.Width")],col=kc$cluster)