%=====================
%takin how many sample
%=====================
number_of_sample = input('Enter the number of samples:');

%============
%taking base
%============
base = input('Enter the base of triangles:');

%=====================
%taking sample values
%====================
disp('Input the samples:');

samples = zeros(1, number_of_sample);

for i = 1:number_of_sample
    samples(1,i) = input('');
end

%==========================
%for which to calculate pdf
%===========================
sample_to_calculate = input('Enter a sample:');

prob = 0.0;

height = 2.0 / (number_of_sample * base);
half_base = base / 2;
lower = sample_to_calculate - half_base;
upper = sample_to_calculate + half_base;


%========================================
%finding and summing all probability value
%=========================================
for i = 1:number_of_sample
    if((samples(1, i) >= lower) && (samples(1, i) <= upper))
        prob = prob + ((height * min(abs(samples(1, i) - lower), abs(samples(1, i) - upper))) / half_base);
    end
end

disp('The probability: ');
disp(prob);


