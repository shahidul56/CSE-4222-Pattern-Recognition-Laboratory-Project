function [] = BayesDecisionMaking()

testImage = imread('Test\test4.jpg');
color = colorFeatures(testImage);
shape = shapeFeatures(testImage);
testImageFeatures = [color shape];  %Features of test images

srcFiles = dir('Training\*.jpg');  % the folder in which training images exists
numOfTrainingImages = length(srcFiles);
trainingImageFeatures = zeros(numOfTrainingImages,16);
labels = cell(1, numOfTrainingImages);   %for fruit names(class labels)
for i = 1 : numOfTrainingImages
    imgName = strsplit(srcFiles(i).name,'.');
    imgName = imgName(1);
    imgName = imgName{1};
    labels{i} = imgName;  %class label (fruit name/image name)
    fileName = strcat('Training\',srcFiles(i).name);
    image = imread(fileName);
    color = colorFeatures(image);
    shape = shapeFeatures(image);
    trainingImageFeatures(i,:) = [color shape];  %Features of training images
end

%Probability of happening of each class independent of features = P(Ci)
probabilityOfEachClass = 1/numOfTrainingImages; %in this case it is 0.2

correction = 1;  
P = zeros(5,16);
P(:,:) = correction;
for i=1:16
    distance = zeros(1,5);
    for j=1:5
        distance(j) = pdist2(trainingImageFeatures(j,i), testImageFeatures(i), 'cityblock');
    end
    [sortedDist index] = sort(distance);
    P(index(1),i) = 1 + correction;
end

%posterior probability
Px = [1 1 1 1 1];
for i=1:5
    for j=1:16
        Px(i) = Px(i) * P(i,j);
    end
    Px(i) = Px(i) * probabilityOfEachClass;
end
disp(Px);
[sortedPx index] = sort(Px, 'descend');
disp(labels(index(1)));
end