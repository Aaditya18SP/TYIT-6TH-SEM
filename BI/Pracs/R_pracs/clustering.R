newiris <- iris
#print(newiris)
<<<<<<< HEAD
#remove the SPECIES column from the iris dataset
newiris$Species <- NULL

#always mention this before plot
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\clutering.png')
kc <-kmeans(newiris,3)
print(kc)
print(paste("type of iris is : ",typeof(newiris)))
#table() compares the iris$species with the clusters formed and gives the number of species in that column
table(iris$Species,kc$cluster)
cluster_colors <-c("yellow","blue","green")
plot(newiris[c("Sepal.Length","Sepal.Width")],col=cluster_colors[kc$cluster],pch=2)

#centroid colors
centroid_colors<-c("red","black","darkgreen")
#draw the centroid separately

# [row,column]-> if we give [,column] then we select all the rows with the specified columns
points(kc$centers[,c("Sepal.Length","Sepal.Width")],col=centroid_colors,pch=8,cex=2)
dev.off()
#plot(newiris[c("Sepal.Length","Sepal.Width")],col=kc$cluster)
=======
newiris$Species <- NULL
kc <-kmeans(newiris,3)
print(kc)
table(iris$Species,kc$cluster)
plot(newiris[c("Sepal.Length","Sepal.Width")],col=kc$cluster)
points(kc$centers[,c("Sepal.Length","Sepal.Width")],col=1:3,pch=8,cex=2)
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\clutering.png')
dev.off()
plot(newiris[c("Sepal.Length","Sepal.Width")],col=kc$cluster)
>>>>>>> 767a5f9f9b76cf5f9d0912e6ab3ac5d21537cfac
