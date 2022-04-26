package uz.online.pharma.onlinepharma.controller;

import lombok.RequiredArgsConstructor;
import uz.online.pharma.onlinepharma.service.BaseService;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {
    protected final S service;



}
