patient
    id
    first_name
    last_name
    date_of_birth
    sex
    insurance_id
    employer_id
    eligibility_status
    remaining_balance
    remaining_deductible
    last_verification
    household_id

patient_deductible
    id
    patient_id
    deductible_id
    remaining_deductible

household
    id
    subscriber_id
    patient_id

insurance
    id
    name

deductible
    id
    insurance_id
    category
    is_standard
    individual
    family

coverage
    id
    code_range
    category
    deductible
    coverage
    co_pay
    exception

carrier
    id
    name
    phone
    electronic_id
    address_1
    address_2
    city
    state
    zip
    website
    network_status

plan
    id
    name
    number
    status
    fee_schedule_id
    notes


employer
    id
    name


select p.first_name, p.last_name, p.insurance_id, i.name, d.* from patient p 
join insurance i on p.insurance_id  = i.id 
join deductible d on p.insurance_id = d.insurance_id 
where 
p.insurance_id = 2