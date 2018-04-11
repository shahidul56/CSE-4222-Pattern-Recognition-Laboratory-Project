

number_of_samples = input('Enter the number of samples:');
base = input('Enter the base of rectangles:');

disp('Input the samples:');

samples = zeros(1, number_of_samples);

for i = 1:number_of_samples
    samples(1,i) = input('');
end

sample_to_calculate = input('Enter a sample:');

prob = 0.0;

height = 1.0 / (number_of_samples * base);
half_base = base / 2;
lower = sample_to_calculate - half_base;
upper = sample_to_calculate + half_base;

for i = 1:number_of_samples
    if((samples(1, i) >= lower) && (samples(1, i) <= upper))
        prob = prob + height;
    end
end

disp('The probability: ');
disp(prob);


