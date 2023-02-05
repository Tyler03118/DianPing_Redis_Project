--1.1 优惠券id
local voucherId = ARGV[1]
--1.2 用户id
local userId = ARGV[2]

--2.1 库存key
local stockKey = 'seckill:stock' .. voucherId
--2.2 订单key
local orderKey = 'seckill:order' .. voucherId

--3 脚本业务
--3.1 判断库存是否充足
if(toNumber(redis.call('get', stock)) <= 0) then
    --库存不足
    return 1
end

--3.2 判断用户是否下单
if(redis.call('sismember', orderKey, userId) == 1) then
    --说明重复下单
    return 2
end

--3.3 扣库存 incrby stockKey -1
redis.call('incrby', stockKey, -1)
--3.4 下单 sadd orderKey userK
redis.call('sadd', orderKey, userId)
return 0