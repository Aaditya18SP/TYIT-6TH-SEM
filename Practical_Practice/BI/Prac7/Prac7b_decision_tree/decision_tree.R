#package requires- party
#install.packages('party')

library(party)

#load the dataset

#print a few rows of the dataset, used head() fucntion for it
print(head(readingSkills))
print(class(readingSkills))

png(file="D:\\BSCIT\\TY\\6TH SEM\\TYIT-6TH-SEM\\Practical_Practice\\BI\\Prac7\\Outputs\\decision_tree.png")

input.dat= readingSkills[1:105,]
output.tree= ctree(nativeSpeaker~shoeSize+age+score,data=input.dat)
plot(output.tree)
dev.off()
plot(output.tree)
