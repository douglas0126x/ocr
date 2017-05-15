set imgPath=E:\svn2\DOC_ocr\Image\Train
set rstPath=.\rst
set saveImg=-bw

//if not exist %rstPath% (md %rstPath%) 

bcrbmk -doc -ch -cfg ScanPen_PC.cfg ./Img rst.txt -bw
//pause