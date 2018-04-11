function shapeMoments = shapeFeatures(image)


% This function Calculates the Seven Invariant Moments for the image A
% the output of this function is a Vector M ; called the Feature vector
% the vector M is a column vector containing M1,M2,....M7
I = double(rgb2gray(image))/255;
[r, c]=size(I); 
m=zeros(r,c); 
% geometric moments 
for i=0:1 
    for j=0:1 
        for x=1:r 
            for y=1:c 
                m(i+1,j+1)=m(i+1,j+1)+(x^i*y^j*I(x,y)); 
            end
        end
    end
end

xb=m(2,1)/m(1,1); % these are image centroid
yb=m(1,2)/m(1,1);

% central moments equ 2.7
u=[ 0 0 0 0;0 0 0 0;0 0 0 0;0 0 0 0]; 
for i=0:3 
    for j=0:3 
        for x=1:r 
            for y=1:c 
u(i+1,j+1)=u(i+1,j+1)+times(times(power((x-xb),i),power((y-yb),j)),I(x,y)); 
            end
        end
    end
end

% scale invariant moments 
n=[ 0 0 0 0;0 0 0 0;0 0 0 0;0 0 0 0]; 
for i=0:3 
    for j=0:3 
        n(i+1,j+1)=u(i+1,j+1)/(u(1,1)^(1+(i+j)/2)); 
    end
end

%rotation invariant moments 
I_1= n(3,1)+ n(1,3); 
I_2=(n(3,1)- n(1,3) )^2+ (2*n(2,2))^2; 
I_3=(n(4,1)-3*n(2,3))^2+ (3*n(3,2)-n(1,4))^2; 
I_4=(n(4,1)+n(2,3))^2+ (n(3,2)+n(1,4))^2; 
I_5=(n(4,1)-3*n(2,3))*(n(4,1)+n(2,3))*((n(4,1)+n(2,3))^2-3*(n(3,2)+n(1,4))^2)...
    +(3*n(3,2)-n(1,4))*(n(3,2)+n(1,4))*(3*(n(4,1)+n(2,3))^2-(n(3,2)+n(1,4))^2); 
I_6=(n(3,1)-n(1,3))*((n(4,1)+n(2,3))^2-(n(3,2)+n(1,4))^2)+ 4*n(2,2)*(n(4,1)...
    +n(2,3))*(n(3,2)+n(1,4)); 
I_7=(3*n(3,2)-n(1,4))*(n(4,1)+n(2,3))*((n(4,1)+n(2,3))^2- 3*(n(3,2)+n(1,4))^2 )...
    - (n(1,4)-3*n(2,3))*(n(3,2)+n(1,4))*(3*(n(4,1)+n(2,3))^2-(n(3,2)+n(1,4))^2);
%I_8=n(2,2)*((n(4,1)+n(2,3))^2-(n(1,4)+n(3,2))^2)-(n(3,1)-n(1,3))*(n(4,1)+n(2,3))*(n(1,4)+n(3,2));

shapeMoments= [I_1 I_2 I_3 I_4 I_5 I_6 I_7];


