library(party)
print(head(readingSkills))
input.dat<- readingSkills[c(1:105),]
png(file='D:\\A029_TYIT_Aaditya\\TYIT-6TH-SEM\\BI\\Pracs\\R_prac_output\\decision_tree.png')
#create the output tree
output.tree<-ctree(nativeSpeaker~age+shoeSize+score,data=input.dat)
print(output.tree)
plot(output.tree)
dev.off()
plot(output.tree)
