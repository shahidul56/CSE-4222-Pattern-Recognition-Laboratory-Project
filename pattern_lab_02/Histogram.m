
%
num_class = input('Input the number of class:');
num_sample = input('Input the number of samples of each class:');

%fileID = fopen('input_histogram.txt','r');
fileID = fopen('input1.txt','r');
data1 = fscanf(fileID,'%f');

data = zeros(num_class, num_sample);


k = 1;
for i = 1:num_class
    for j = 1:num_sample
        data(i, j) = data1(k,1);
        k = k + 1;
    end
end

sample = input('Iput a sample:');



bin = ceil(sqrt(num_sample));
upper = max(data1);
lower = min(data1);
range = (upper - lower) / bin;

while lower < upper
    if(sample >= lower + range)
        lower = lower + range;
    else
        break;
    end
end
upper = lower + range;

prob = zeros(1, num_class);
sum_prob = 0.0;

for i = 1:num_class
    freq = 0;
    for j = 1:num_sample
        if(data(i, j) >= lower)
            if(data(i, j) <= upper)
                freq = freq + 1
            end
        end
    end
    prob(1, i) = (1.0/num_class)*(freq*1.0/(num_sample*(upper - lower))*1.0);
    sum_prob = sum_prob + prob(1, i);
end

for i = 1:num_class
    prob(1, i) = prob(1, i) / sum_prob;
end

[max_v, ind] = max(prob)

disp(prob(1,1));
disp(prob(1,2));

disp(' The sample is belong to class:  ');
disp(ind);

