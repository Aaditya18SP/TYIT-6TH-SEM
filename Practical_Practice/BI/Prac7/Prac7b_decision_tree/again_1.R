#decision tree
library(party)
png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\again_1.png")
print(head(readingSkills))
idata<-readingSkills[1:105,]
tree=ctree(nativeSpeaker~shoeSize+age+score,data=idata)
plot(tree)
dev.off()
