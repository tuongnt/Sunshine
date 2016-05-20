package me.tuongnt.sunshine.data.mapper;

/**
 * Created by tuong.nguyen on 5/17/16.
 */
public abstract class BaseTransform<FromObject, ToObject>{

    public abstract ToObject transform (FromObject fromObject);
}
