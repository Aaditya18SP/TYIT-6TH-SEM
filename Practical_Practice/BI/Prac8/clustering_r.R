#clustering
#import the dataset

png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac8\\clustering.png")
newiris<-iris

#remove the species column
newiris$Species<-NULL

print(newiris)

#create the clusters
kc<-kmeans(newiris,3)
print(kc)
#find the number of species in each cluster
table(iris$Species,kc$cluster)

#plot the clusters
plot(newiris[, c("Petal.Width","Petal.Length")],col=kc$cluster)

#plot the centroids
points(kc$centers[,c("Petal.Width","Petal.Length")], col=1:3, pch=8, cex=1.5)

dev.off()


